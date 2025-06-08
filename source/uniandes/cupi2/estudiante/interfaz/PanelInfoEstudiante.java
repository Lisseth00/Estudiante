/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad de los Andes (Bogot� - Colombia) 
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 * 
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n2_estudiante
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.estudiante.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.estudiante.mundo.Estudiante;

/**
 * Panel con la informaci�n del estudiante.
 */
@SuppressWarnings("serial")
public class PanelInfoEstudiante extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta Promedio.
     */
    private JLabel lblPromedio;
    
    /**
     * etiqueta semestre
     */
    private JLabel lblSemestre;

    /**
     * Etiqueta c�digo.
     */
    private JLabel lblCodigo;

    /**
     * Etiqueta Nombre.
     */
    private JLabel lblNombre;

    /**
     * Etiqueta Apellido.
     */
    private JLabel lblApellido;

    /**
     * Etiqueta para la imagen.
     */
    private JLabel lblImagen;
    
    /**
     * etiqueta sueldo
     */
    private JLabel lblSueldo;

    /**
     * Campo de texto donde se muestra el promedio.
     */
    private JTextField txtPromedio;

    /**
     * Campo de texto donde se muestra el c�digo.
     */
    private JTextField txtCodigo;

    /**
     * Campo de texto donde se muestra el nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto donde se muestra el apellido.
     */
    private JTextField txtApellido;
    
    /**
     * campo de texto donde se muestra el semestre
     */
    private JTextField txtSemestre;
    
    /**
     * campo de texto donde se muestra el sueldo del estudiante
     */
    private JTextField txtSueldo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Crea el panel con la informaci�n del estudiante.
     */
    public PanelInfoEstudiante( )
    {
        setBorder( new TitledBorder( "Informaci�n del estudiante" ) );
        setLayout( new BorderLayout( ) );

        JPanel panelAux = new JPanel( );
        panelAux.setLayout( new GridLayout( 7, 2 ) );
        txtCodigo = new JTextField( );
        txtCodigo.setEditable( false );
        txtPromedio = new JTextField( );
        txtPromedio.setEditable( false );
        txtApellido = new JTextField( );
        txtApellido.setEditable( false );
        txtNombre = new JTextField( );
        txtNombre.setEditable( false );
        txtSemestre = new JTextField( );
        txtSemestre.setEditable( false );
        txtSueldo = new JTextField( );
        txtSueldo.setEditable( false);
        lblPromedio = new JLabel( ); 
        lblCodigo = new JLabel( );
        lblNombre = new JLabel( );
        lblApellido = new JLabel( );
        lblSemestre = new JLabel( );
        lblSueldo = new JLabel ( );
        lblSueldo.setText( "Sueldo: ");
        lblPromedio.setText( "Promedio:" );
        lblCodigo.setText( "C�digo:" );
        lblNombre.setText( "Nombre:" );
        lblApellido.setText( "Apellido:" );
        lblSemestre.setText( "Semestre: " );
        panelAux.add( lblSueldo);
        panelAux.add( txtSueldo);
        
        panelAux.add( lblCodigo );
        panelAux.add( txtCodigo );
        panelAux.add( lblNombre );
        panelAux.add( txtNombre );
        panelAux.add( lblApellido );
        panelAux.add( txtApellido );
        panelAux.add( lblPromedio );
        panelAux.add( txtPromedio );
        panelAux.add( lblSemestre );
        panelAux.add( txtSemestre );

        lblImagen = new JLabel( );
        ImageIcon icono = new ImageIcon( "./data/estudiante.png" );
        lblImagen.setIcon( icono );

        add( lblImagen, BorderLayout.WEST );
        add( panelAux, BorderLayout.CENTER );

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Actualiza al informaci�n del panel con la informaci�n del estudiante dado.
     * @param pEstudiante Estudiante de los cursos. pEstudiante != null && pEstudiante != "".
     */
    public void actualizar( Estudiante pEstudiante )
    {
        double promedio = pEstudiante.calcularPromedioEstudiante();
        if(promedio != -1)
        {
            txtPromedio.setText( pEstudiante.formatearPromedio(promedio) );
        }
        else
        {
            txtPromedio.setText( "0" );
        }
        txtCodigo.setText( pEstudiante.darCodigo( ) + "" );
        txtNombre.setText( pEstudiante.darNombre( ) );
        txtApellido.setText( pEstudiante.darApellido( ) );
        txtSemestre.setText(String.valueOf(pEstudiante.darSemestre( ))); 
        txtSueldo.setText(String.valueOf(pEstudiante.darSueldoFormateado( )));
    }

}
