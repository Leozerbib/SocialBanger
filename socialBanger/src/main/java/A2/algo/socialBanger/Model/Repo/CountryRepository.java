package A2.algo.socialBanger.Model.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import A2.algo.socialBanger.Model.Entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    @Query("SELECT c FROM Country c WHERE c.country = ?1")
    Country findCountryByName(String name);

    List<Country> findAll();
    // Exemple d'insertion : countryRepository.save(new Country(...));
    // Exemple de mise à jour : countryRepository.save(existingCountry);
    // Exemple de suppression : countryRepository.deleteById(countryId);
}
