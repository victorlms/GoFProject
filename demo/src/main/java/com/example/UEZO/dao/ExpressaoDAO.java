package com.example.UEZO.dao;

import com.example.UEZO.model.Expression;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Interface que represetna o Facade
 *
 * Ver também FakeExpressionDataAccessService que o implementa
 * VICTOR LIMA E MELLO DOS SANTOS
 * 152.333.2051
 */
public interface ExpressaoDAO {

    int insertExpression(UUID id, Expression expression);

    default  int insertExpression(Expression expression){
        UUID id = UUID.randomUUID();
        return insertExpression(id, expression);
    }

    List<Expression> selectAllExpressions();

    Optional<Expression> selectExpressionById(UUID id );

    int deleteExpressionById(UUID id);

    int updateExpressionById(UUID id, Expression expression);
}
