/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.gd.dao;

import br.com.gd.modelo.Usuario;
import java.util.List;

/**
 *
 * @author Aninha S.A
 * @param <T>
 */
public interface IUsuarioDAO <T extends Usuario>{
    public List<Usuario>consultar(T t);
    public boolean acessar(T t);
}
