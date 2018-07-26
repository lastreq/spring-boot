package test.prog.dao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import test.prog.model.Profile;
import test.prog.model.ProfileInfo;


import java.util.Optional;


@Repository
public class ProfileDaoImpl implements ProfileDao {


    private static final String SQL_GET_PROFILE_BY_ID =
            "select id, firstname, lastname, address, age, email, country from profiles where id = :id";

    private static final String SQL_INSERT_PROFILE =
            "insert into profiles (firstname, lastname,address, age, email, country) values (:firstName, :lastName,:address, :age, :email, :country)";


    private static final String SQL_DELETE_PROFILE =
            "delete from profiles where id = :id";

    private final ProfileMapper profileMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired

    public ProfileDaoImpl(
            ProfileMapper profileMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.profileMapper = profileMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

/*    @Override
    public Profile findById(int id) {

        return this.entityManager.find(Profile.class, id);
    }
*/

/*
    public List<ProfileInfo> listProfileInfo() {
        String sql = "Select new " + ProfileInfo.class.getName() //
                + "(e.id, e.firstName, e.lastName, e.address,e.age,e.email,e.country) " //
                + " from " + Profile.class.getName() + " e ";
        Query query = entityManager.createQuery(sql, ProfileInfo.class);
        return query.getResultList();
    }*/
    @Override
    public Optional<Profile> getProfileById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            SQL_GET_PROFILE_BY_ID,
                            params,
                            profileMapper
                    )
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void insertProfile(String firstName, String lastName, String address, int age, String email, String country) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("firstName", firstName);
        params.addValue("lastName", lastName);
        params.addValue("address", address);
        params.addValue("age", age);
        params.addValue("email", email);
        params.addValue("country", country);
        jdbcTemplate.update(SQL_INSERT_PROFILE, params);
    }



    @Override
    public void deleteProfileById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        jdbcTemplate.update(SQL_DELETE_PROFILE, params);
    }
}