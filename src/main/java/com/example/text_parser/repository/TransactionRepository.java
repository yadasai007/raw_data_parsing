package com.example.text_parser.repository;
import com.example.text_parser.model.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionDetails, Long> {
	public String findByTransactionType(String transactionType);
}