package com.hardhwpc.backend.services;

import com.hardhwpc.backend.entities.Message;
import com.hardhwpc.backend.entities.Product;
import com.hardhwpc.backend.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public Message save(Message bean) {
        return messageRepository.save(bean);
    }

    public String count() {
       return String.valueOf(messageRepository.count());
    }

    @Transactional(readOnly = true)
    public List<Message> showAllMessages(int pageNumber, int pageSize, String sortBy, String type) {
        Pageable paging;
        if(type.equalsIgnoreCase("ascending")) {
            paging = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).ascending());
        }else paging = PageRequest.of(pageNumber,pageSize,Sort.by(sortBy).descending());
        Page<Message> pagedResult = messageRepository.findAll(paging);
        if ( pagedResult.hasContent() ) {
            return pagedResult.getContent();
        }
        else {
            return new ArrayList<>();
        }
    }

}
