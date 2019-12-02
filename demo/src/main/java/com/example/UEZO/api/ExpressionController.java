package com.example.UEZO.api;

import com.example.UEZO.model.Expression;
import com.example.UEZO.service.ExpressaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

/**
 * Controller que, como singleton, através do Service, requisita métodos do DAO(Facade)
 * VICTOR LIMA E MELLO DOS SANTOS
 * 152.333.2051
 */
@RequestMapping("api/v1/expression")
@RestController
public class ExpressionController {

    private final ExpressaoService expressaoService;

    @Autowired
    public ExpressionController(ExpressaoService expressaoService) {
        this.expressaoService = expressaoService;
    }

    @PostMapping
    public void addExpression(@Valid @NotNull  @RequestBody Expression expression) {
        expressaoService.addExpression(expression);
    }

    @GetMapping
    public List<Expression> getAllExpressions() {
        return expressaoService.getAllExpressions();
    }

    @GetMapping(path = "{id}")
    public Expression getExpressionById(@PathVariable("id") UUID id) {
        return expressaoService.getExpressionById(id).orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteExpressionById(@PathVariable("id") UUID id) {
        expressaoService.deleteExpression(id);
    }

    @PutMapping
    public void updateExpression(@PathVariable("id") UUID id,@Valid @NotNull @RequestBody Expression expressionToUpdate) {
        expressaoService.updateExpression(id, expressionToUpdate);
    }
}
