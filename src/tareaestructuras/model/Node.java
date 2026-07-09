/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tareaestructuras.model;

/**
 *
 * @author sebastian
 */
public class Node
{
    Empleado emp;
    int height;
    Node left;
    Node right;

    public Node(Empleado emp)
    {
        this.emp = emp;
        this.height = 1;
        this.left = null;
        this.right = null;
    }

    public Empleado getEmp()
    {
        return emp;
    }

    public void setEmp(Empleado emp)
    {
        this.emp = emp;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public Node getLeft()
    {
        return left;
    }

    public void setLeft(Node left)
    {
        this.left = left;
    }

    public Node getRight()
    {
        return right;
    }

    public void setRight(Node right)
    {
        this.right = right;
    }
}
