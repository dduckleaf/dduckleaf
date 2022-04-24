package com.greedy.dduckleaf.faq.repository;

import com.greedy.dduckleaf.faq.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepository extends JpaRepository<Faq, Integer> {
}
