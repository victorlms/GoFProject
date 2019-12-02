package com.example.UEZO.dao;

import com.example.UEZO.model.Expression;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * Classe que implementa o facade, sendo que, outras classes também poderiam o utilizar.
 *
 * Ver também Expressao Service
 * VICTOR LIMA E MELLO DOS SANTOS
 * 152.333.2051
 */
@Repository("fakeDAO")
public class FakeExpressionDataAccessService implements ExpressaoDAO {
    private static List<Expression> DB = new ArrayList<>();

    @Override
    public int insertExpression(UUID id, Expression expression) {
        DB.add(new Expression(id, expression.getExpressao()));
        return 1;
    }

    @Override
    public List<Expression> selectAllExpressions() {
        return DB;
    }

    @Override
    public Optional<Expression> selectExpressionById(UUID id) {
        return DB.stream().filter(expression -> expression.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteExpressionById(UUID id) {
        Optional<Expression> expressionMaybe = selectExpressionById(id);
        if (expressionMaybe.isPresent()) {
            return 0;
        }
        DB.remove(expressionMaybe.get());
        return 1;
    }

    @Override
    public int updateExpressionById(UUID id, Expression update) {
        return selectExpressionById(id).map(expression -> {
            int indexOfExpressionToUpdate = DB.indexOf(expression);
            if (indexOfExpressionToUpdate >= 0) {
                DB.set(indexOfExpressionToUpdate, new Expression(id, update.getExpressao()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }


}
