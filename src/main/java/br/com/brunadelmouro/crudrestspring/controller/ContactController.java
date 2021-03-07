package br.com.brunadelmouro.crudrestspring.controller;

import br.com.brunadelmouro.crudrestspring.model.Contact;
import br.com.brunadelmouro.crudrestspring.repository.ContactRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController /* @Controller and @ResponseBody */
@RequestMapping({"/contacts"})  /* route */
public class ContactController {

    private ContactRepository repository;

    public ContactController(ContactRepository repository) {
        this.repository = repository;
    }

    /* listing all contacts */
    @GetMapping
    public List findAll(){
        return  repository.findAll();
    }

    /* getting a specific contact by ID */
    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return  repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    /* creating a new contact */
    @PostMapping
    public Contact create(@RequestBody Contact contact){
        return repository.save(contact);
    }

    /* updating a contact */
    @PutMapping(value = "/{id}")
    public  ResponseEntity update(@PathVariable("id") long id,
                                  @RequestBody Contact contact){
        return  repository.findById(id)
                .map(record -> {
                    record.setName(contact.getName());
                    record.setEmail(contact.getEmail());
                    record.setPhone(contact.getPhone());
                    Contact updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    /* removing a contact */
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }

    /*
    *   List all contacts - @GetMapping(“/contacts)
    *   Get a specific contact by ID - @GetMapping(“/contacts/{id}”)
    *   Remove a contact by ID - @DeleteMapping(“/contacts/{id}”)
    *   Create a new contact - @PostMapping(“/contacts)
    *   Update contact details - @PutMapping(“/contacts/{id}”)
    * */
}
