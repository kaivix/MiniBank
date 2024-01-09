package com.kaivix.mini_bank.Service;

import com.kaivix.mini_bank.Models.Card;
import com.kaivix.mini_bank.Repositories.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    public CardRepository cardRepository;
    public Card findById(Long id){
        return cardRepository.findById(id).orElse(null);
    }

}
