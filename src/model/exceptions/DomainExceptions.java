/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.exceptions;

/**
 *
 * @author Gabriel Augusto
 */
public class DomainExceptions extends RuntimeException{
    private static final long serialVersionUID = 1;
    
    public DomainExceptions(String msg) {
        super(msg);
    }
}
