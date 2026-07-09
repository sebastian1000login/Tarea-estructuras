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
    Node left;
    Node right;

    public Node(Empleado emp)
    {
        this.emp = emp;
        this.left = null;
        this.right = null;
    }
}
