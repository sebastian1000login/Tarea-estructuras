/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareaestructuras.controller;

import tareaestructuras.model.Empleado;
import tareaestructuras.model.Node;
import javax.swing.JTextArea;

/**
 *
 * @author sebastian
 */
public class TreeController
{
    Node root;
    JTextArea area;

    public TreeController(JTextArea area)
    {
        this.root = null;
        this.area = area;
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
    
    int max(int a, int b)
    {
        if (a < b)
        {
            return b;
        }else if (b < a)
        {
            return a;
        }else
        {
            return a;
        }
    }
    
    int getBalance(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        return height(node.getLeft()) - height(node.getRight());
    }
    
    Node rotateRight(Node node)
    {
        Node left = node.getLeft();
        Node aux = left.getRight();
        
        left.setRight(node);
        node.setLeft(aux);
        
        node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);
        left.setHeight(max(height(left.getLeft()), height(left.getRight())) + 1);
        
        return left;
    }
    
    Node rotateLeft(Node node)
    {
        Node right = node.getRight();
        Node aux = right.getLeft();
        
        right.setLeft(node);
        node.setRight(aux);
        
        node.setHeight(max(height(node.getLeft()), height(node.getRight())) + 1);
        right.setHeight(max(height(right.getLeft()), height(right.getRight())) + 1);
        
        return right;
    }
    
    public Node push(Node node, int id, String name, float salary)
    {        
        if (node == null)
        {
            Empleado emp = new Empleado(id, name, salary);
            Node nuevo = new Node(emp);
            return nuevo;
        }
        if (id < node.getEmp().getId())
        {
            node.setLeft(push(node.getLeft(), id, name, salary));
        } else if (id > node.getEmp().getId())
        {
            node.setRight(push(node.getRight(), id, name, salary));
        } else
        {
            return node;
        }
        node.setHeight(1 + max(height(node.getLeft()), height(node.getRight())));
        
        int balance = getBalance(node);
        
        if (balance > 1 && id < node.getLeft().getEmp().getId())
        {
            return rotateRight(node);
        }
        if (balance < -1 && id > node.getRight().getEmp().getId())
        {
            return rotateLeft(node);
        }
        if (balance > 1 && id > node.getLeft().getEmp().getId())
        {
            node.setLeft(rotateLeft(node.getLeft()));
            return rotateRight(node);
        }
        if (balance < -1 && id < node.getRight().getEmp().getId())
        {
            node.setRight(rotateRight(node.getRight()));
            return rotateLeft(node);
        }
        
        return node;
    }
    
    public void preOrder(Node node)
    {
        if (node != null)
        {
            area.append(node.getEmp().getId() + "\t" + node.getEmp().getName() + "\t" + node.getEmp().getSalary() + "\n");
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
    }
    
    public void inOrder(Node node)
    {
        if (node != null)
        {
            inOrder(node.getLeft());
            area.append(node.getEmp().getId() + "\t" + node.getEmp().getName() + "\t" + node.getEmp().getSalary() + "\n");
            inOrder(node.getRight());
        }
    }
    
    public void postOrder(Node node)
    {
        if (node != null)
        {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            area.append(node.getEmp().getId() + "\t" + node.getEmp().getName() + "\t" + node.getEmp().getSalary() + "\n");
        }
    }
    
    public Node getRoot()
    {
        return this.root;
    }
    
    public void insert(int id, String name, float salary)
    {
        this.root = this.push(this.root, id, name, salary);
    }
    
    public Node search(Node node, int id)
    {
        if (node == null || id == node.getEmp().getId())
        {
            return node;
        }else
        {
            if (id < node.getEmp().getId())
            {
                return search(node.getLeft(), id);
            }else
            {
                return search(node.getRight(), id);
            }
        }
    }
    
    public void edit(int id, String name, float salary)
    {
        Node node = search(this.root, id);
        node.getEmp().setName(name);
        node.getEmp().setSalary(salary);
    }
}
