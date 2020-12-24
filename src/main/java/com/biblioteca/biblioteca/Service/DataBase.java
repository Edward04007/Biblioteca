package com.biblioteca.biblioteca.Service;
import com.biblioteca.biblioteca.Model.Adicionar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataBase extends JpaRepository<Adicionar, Integer>{
    
}