/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gd.dao;

import br.com.gd.modelo.Livro;
import java.util.List;

/**
 *
 * @author Aninha S.A
 */
public interface IBaseDAO {
    public void incluir(Object o);
    public void alterar(Object o);
    public void excluir(Object o);
}
