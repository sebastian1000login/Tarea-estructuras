/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareaestructuras.controller;

import tareaestructuras.model.Empleado;
import tareaestructuras.model.Node;

/**
 *
 * @author sebastian
 */
public class TreeController
{
    Node root;

    public TreeController()
    {
    }
    
    int height(Node node)
    {
        if (node == null)
        {
            return 0;
        }else
        {
            return node.getHeight();
        }
    }
    
    void rotateRight()
    {
        
    }
    
    public void push(int id, String name, float salary)
    {
        Node aux = null;
        Node back = null;
        Empleado emp = new Empleado(id, name, salary);
        Node nuevo = new Node(emp);
        
        if (root == null)
        {
            root = nuevo;
        }else
        {
            aux = root;
            while (aux != null)
            {
                back = aux;
                if (id < aux.getEmp().getId())
                {
                    if (back.getRight() == null)
                    {
                        back.setHeight(back.getHeight() + 1);
                    }
                    aux = aux.getLeft();
                }else
                {
                    if (back.getLeft() == null)
                    {
                        back.setHeight(back.getHeight() + 1);
                    }
                    aux = aux.getRight();
                }
            }
            if (id < back.getEmp().getId())
            {
                back.setLeft(nuevo);
            }else
            {
                back.setRight(nuevo);
            }
        }
    }
}
