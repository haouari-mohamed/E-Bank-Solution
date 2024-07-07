package tech.bank.banksysteme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.bank.banksysteme.model.Beneficiaire;
import tech.bank.banksysteme.repository.BeneficaireRepo;

import java.util.List;

@Service
public class BeneficiaireService {

    @Autowired
    private BeneficaireRepo beneficaireRepo;

    /**
     * Retrieves all beneficiaires from the repository.
     *
     * @return List of all beneficiaires stored in the repository.
     */
    public List<Beneficiaire> getAllBeneficiaires() {
        return beneficaireRepo.findAll();
    }

    /**
     * Retrieves a beneficiaire by its unique identifier.
     *
     * @param id The unique identifier of the beneficiaire to retrieve.
     * @return The beneficiaire corresponding to the provided id.
     * @throws RuntimeException If no beneficiaire exists with the provided id.
     */
    public Beneficiaire getBeneficiaireById(Long id) {
        return beneficaireRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Beneficiaire not found with id: " + id));
    }

    /**
     * Saves a new beneficiaire to the repository.
     *
     * @param beneficiaire The beneficiaire object to be created.
     * @return The created beneficiaire object.
     */
    public Beneficiaire createBeneficiaire(Beneficiaire beneficiaire) {
        return beneficaireRepo.save(beneficiaire);
    }

    /**
     * Updates an existing beneficiaire with new details.
     *
     * @param id                The unique identifier of the beneficiaire to update.
     * @param beneficiaireDetails The updated beneficiaire details.
     * @return The updated beneficiaire object.
     * @throws RuntimeException If no beneficiaire exists with the provided id.
     */
    public Beneficiaire updateBeneficiaire(Long id, Beneficiaire beneficiaireDetails) {
        Beneficiaire beneficiaire = getBeneficiaireById(id);
        beneficiaire.setNom(beneficiaireDetails.getNom());
        beneficiaire.setId(beneficiaireDetails.getId());
        return beneficaireRepo.save(beneficiaire);
    }

    /**
     * Deletes a beneficiaire from the repository.
     *
     * @param id The unique identifier of the beneficiaire to delete.
     */
    public void deleteBeneficiaire(Long id) {
        beneficaireRepo.deleteById(id);
    }
}
