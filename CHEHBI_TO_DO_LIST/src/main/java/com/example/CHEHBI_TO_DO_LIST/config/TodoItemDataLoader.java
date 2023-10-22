package com.example.CHEHBI_TO_DO_LIST.config;

import com.example.CHEHBI_TO_DO_LIST.models.TodoItem;
import com.example.CHEHBI_TO_DO_LIST.repositories.TodoItemRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TodoItemDataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(TodoItemDataLoader.class);

    @Autowired
    TodoItemRepository todoItemRepository;

    @Override
    public void run(String... args) throws Exception {
        loadSeedData();
    }

    private void loadSeedData() {
        if (todoItemRepository.count() == 0) {
            TodoItem todoItem1 = new TodoItem("assignment spring boot");
            TodoItem todoItem2 = new TodoItem("preparing the presentation speech");

            todoItemRepository.save(todoItem1);
            todoItemRepository.save(todoItem2); 
        }

        logger.info("Number of TodoItems: {}", todoItemRepository.count());
    }
    
}
