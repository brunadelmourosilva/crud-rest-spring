package br.com.brunadelmouro.crudrestspring.repository;


import br.com.brunadelmouro.crudrestspring.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}


