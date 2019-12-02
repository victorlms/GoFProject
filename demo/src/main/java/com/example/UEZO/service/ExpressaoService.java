package com.example.UEZO.service;

import com.example.UEZO.dao.ExpressaoDAO;
import com.example.UEZO.model.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service que cria a ponte "Bridge" entre o Facade e o controller
 * VICTOR LIMA E MELLO DOS SANTOS
 * 152.333.2051
 */
@Service
public class ExpressaoService {

    private final ExpressaoDAO expressaoDAO;

    @Autowired
    public ExpressaoService(@Qualifier("fakeDAO") ExpressaoDAO expressaoDAO) {
        this.expressaoDAO = expressaoDAO;
    }

    public int addExpression(Expression expression) {
        return expressaoDAO.insertExpression(expression);
    }

    public List<Expression> getAllExpressions() {
        return expressaoDAO.selectAllExpressions();
    }

    public Optional<Expression> getExpressionById(UUID id) {
        return expressaoDAO.selectExpressionById(id);
    }

    public int deleteExpression(UUID id) {
        return expressaoDAO.deleteExpressionById(id);
    }

    public int updateExpression(UUID id, Expression expression) {
        return expressaoDAO.updateExpressionById(id, expression);
    }
}
