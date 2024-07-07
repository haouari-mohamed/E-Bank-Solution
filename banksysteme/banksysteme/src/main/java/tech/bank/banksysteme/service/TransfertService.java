package tech.bank.banksysteme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.bank.banksysteme.model.Transfert;
import tech.bank.banksysteme.repository.TransfertRepo;

import java.util.List;

@Service
public class TransfertService {

    @Autowired
    private TransfertRepo transfertRepo;

    public List<Transfert> getAllTransferts() {
        return transfertRepo.findAll();
    }

    public Transfert getTransfertById(Long id) {
        return transfertRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transfert not found with id: " + id));
    }

    public Transfert createTransfert(Transfert transfert) {
        return transfertRepo.save(transfert);
    }

    public Transfert updateTransfert(Long id, Transfert transfertDetails) {
        Transfert transfert = getTransfertById(id);
        transfert.setMontant(transfertDetails.getMontant());
        transfert.setDescription(transfertDetails.getDescription());
        return transfertRepo.save(transfert);
    }

    public void deleteTransfert(Long id) {
        transfertRepo.deleteById(id);
    }
}
