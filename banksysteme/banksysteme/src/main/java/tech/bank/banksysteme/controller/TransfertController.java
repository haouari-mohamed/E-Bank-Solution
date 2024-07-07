package tech.bank.banksysteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.bank.banksysteme.model.Transfert;
import tech.bank.banksysteme.service.TransfertService;

import java.util.List;

@RestController
@RequestMapping("/api/transferts")
public class TransfertController {

    @Autowired
    private TransfertService transfertService;

    @GetMapping
    public List<Transfert> getAllTransferts() {
        return transfertService.getAllTransferts();
    }

    @GetMapping("/{id}")
    public Transfert getTransfertById(@PathVariable Long id) {
        return transfertService.getTransfertById(id);
    }

    @PostMapping("/create")
    public Transfert createTransfert(@RequestBody Transfert transfert) {
        return transfertService.createTransfert(transfert);
    }

    @PutMapping("/{id}/update")
    public Transfert updateTransfert(@PathVariable Long id, @RequestBody Transfert transfertDetails) {
        return transfertService.updateTransfert(id, transfertDetails);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteTransfert(@PathVariable Long id) {
        transfertService.deleteTransfert(id);
    }


}
