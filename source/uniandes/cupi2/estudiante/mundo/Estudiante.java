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
package uniandes.cupi2.estudiante.mundo;

import uniandes.cupi2.estudiante.mundo.Curso.Departamento;

import java.text.DecimalFormat;

/**
 * Estudiante que tiene 4 cursos.
 */
public class Estudiante
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Representa la nota m�nima para no estar en prueba acad�mica.
     */
    public final static double NOTA_PRUEBA_ACADEMICA = 3.25;

    /**
     * Representa la nota m�nima para ser candidato a beca.
     */
    public final static double NOTA_CANDIDATO_BECA = 4.75;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * C�digo del estudiante.
     */
    private int codigo;

    /**
     * Nombre del estudiante.
     */
    private String nombre;

    /**
     * Apellido del estudiante.
     */
    private String apellido;

    /**
     * Curso 1 del estudiante.
     */
    private Curso curso1;

    /**
     * Curso 2 del estudiante.
     */
    private Curso curso2;

    /**
     * Curso 3 del estudiante.
     */
    private Curso curso3;

    /**
     * Curso 4 del estudiante.
     */
    private Curso curso4;
    
    /**
     * Semestre del estudiante
     */
    private int semestre;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo estudiante con los valores dados por par�metro. <br>
     * <b>post: </b> El estudiante fue inicializado con los siguientes valores: <br>
     * Nombre: Juliana, Apellido: Ram�rez, C�digo: 201612345. <br>
     * Los cursos del estudiante fueron inicializados con los siguientes valores: <br>
     * Curso 1 - C�digo: ISIS1204, Nombre: APO1, Cr�ditos: 3, Departamento: SISTEMAS. <br>
     * Curso 2 - C�digo: MATE1203, Nombre: C�lculo diferencial, Cr�ditos: 3, Departamento: MATEM�TICAS. <br>
     * Curso 3 - C�digo: FISI1100, Nombre: F�sica 1, Cr�ditos: 4, Departamento: FISICA. <br>
     * Curso 4 - C�digo: BIOL1405, Nombre: Biolog�a celular, Cr�ditos: 4, Departamento: BIOLOGIA.
     */
    public Estudiante( )
    {
        nombre = "Juliana";
        apellido = "Ram�rez";
        codigo = 201612345;
        curso1 = new Curso( "ISIS1204", "APO1", 3, Departamento.SISTEMAS );
        curso2 = new Curso( "MATE1203", "C�lculo diferencial", 3, Departamento.MATEMATICAS );
        curso3 = new Curso( "FISI1100", "F�sica 1", 4, Departamento.FISICA );
        curso4 = new Curso( "BIOL1405", "Biolog�a celular", 4, Departamento.BIOLOGIA );
        semestre = 2;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el c�digo del estudiante.
     * @return C�digo del estudiante.
     */
    public int darCodigo( )
    {
        return codigo;
    }

    /**
     * Retorna el nombre del estudiante.
     * @return Nombre del estudiante.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el apellido del estudiante.
     * @return Apellido del estudiante.
     */
    public String darApellido( )
    {
        return apellido;
    }

    /**
     * Retorna el curso 1 del estudiante.
     * @return Curso 1 del estudiante.
     */
    public Curso darCurso1( )
    {
        return curso1;
    }

    /**
     * Retorna el curso 2 del estudiante.
     * @return Curso 2 del estudiante.
     */
    public Curso darCurso2( )
    {
        return curso2;
    }

    /**
     * Retorna el curso 3 del estudiante.
     * @return Curso 3 del estudiante.
     */
    public Curso darCurso3( )
    {
        return curso3;
    }

    /**
     * Retorna el curso 4 del estudiante.
     * @return Curso 4 del estudiante.
     */
    public Curso darCurso4( )
    {
        return curso4;
    }
    
    /**Add commentMore actions
     * retorna el semestre del estudiante
     * @return semestre del estudiante
     */
    public int darSemestre( )
    {
    	return semestre;
    }

    /**
     * Calcula el promedio del estudiante de los cursos que tienen nota asignada.
     * @return Promedio de los cursos que tienen nota asignada. Si ning�n curso tiene nota asignada, retorna -1.
     */
    public double calcularPromedioEstudiante( )
    {
        double totalNota = 0.0;
        double totalCreditos = 0.0;
        double promedio = -1;

        if( curso1.estaCalificado( ) == true )
        {
            totalNota += ( curso1.darNota( ) * curso1.darCreditos( ) );
            totalCreditos += curso1.darCreditos( );
        }
        if( curso2.estaCalificado( ) == true )
        {
            totalNota += ( curso2.darNota( ) * curso2.darCreditos( ) );
            totalCreditos += curso2.darCreditos( );
        }
        if( curso3.estaCalificado( ) == true )
        {
            totalNota += ( curso3.darNota( ) * curso3.darCreditos( ) );
            totalCreditos += curso3.darCreditos( );
        }
        if( curso4.estaCalificado( ) == true )
        {
            totalNota += ( curso4.darNota( ) * curso4.darCreditos( ) );
            totalCreditos += curso4.darCreditos( );
        }

        if( totalCreditos > 0 )
        {
            promedio = ( double )totalNota / totalCreditos;
        }

        return promedio;
    }
    
    public String formatearPromedio(double pPromedio) {
        String promedioStr = String.valueOf(pPromedio);
        if (promedioStr.length() > 2) {
            return promedioStr.substring(0, 3);
        } else {
            return promedioStr;
        }
    }
     

    /**
     * Indica si el estudiante se encuentra en prueba acad�mica.
     * @return Retorna true si se encuentra en prueba, false de lo contrario.
     */
    public boolean estaEnPrueba( )
    {
        boolean prueba = false;
        double promedio = calcularPromedioEstudiante( );
        if( promedio < NOTA_PRUEBA_ACADEMICA )
        {
            prueba = true;
        }

        return prueba;
    }

    /**
     * Indica si el estudiante es candidato a una beca.
     * @return Retorna true si es candidato a beca, false de lo contrario.
     */
    public boolean esCandidatoBeca( )
    {
        boolean beca = false;
        double promedio = calcularPromedioEstudiante( );
        if( promedio >= NOTA_CANDIDATO_BECA )
        {
            beca = true;
        }

        return beca;
    }

    /**
     * Buscar un curso dado su c�digo.
     * @param pCodigoCurso C�digo del curso. pCodigoCurso != null && pCodigoCurso != "".
     * @return Curso buscado, null en caso de no encontrarlo.
     */
    public Curso buscarCurso( String pCodigoCurso )
    {
        Curso buscado = null;

        if( curso1.darCodigo( ).equals( pCodigoCurso ) )
        {
            buscado = curso1;
        }
        else if( curso2.darCodigo( ).equals( pCodigoCurso ) )
        {
            buscado = curso2;
        }
        else if( curso3.darCodigo( ).equals( pCodigoCurso ) )
        {
            buscado = curso3;
        }
        else if( curso4.darCodigo( ).equals( pCodigoCurso ) )
        {
            buscado = curso4;
        }

        return buscado;
    }

    /**
     * Registra la nota al curso dado por par�metro. <br>
     * <b>pre: </b> Existe un curso con el c�digo dado. <br>
     * <b>post: </b> El curso tiene una nueva nota.
     * @param pCodigoCurso C�digo del curso. pCodigoCurso != null && pCodigoCurso != "".
     * @param pNota Nota para asignar al curso. pNota > 0.
     * @return Retorna true si pudo asignar la nota, false de lo contrario.
     */
    public boolean asignarNotaCurso( String pCodigoCurso, double pNota )
    {
        Curso buscado = buscarCurso( pCodigoCurso );
        boolean registra = false;
        if( pNota >= Curso.MINIMA && pNota <= Curso.MAXIMA && buscado != null )
        {
            buscado.asignarNota( pNota );
            registra = true;
        }

        return registra;
    }

    /**
     * Cambia el curso con el c�digo dado por par�metro a un nuevo curso con los valores dados por par�metro. <br>
     * Si ya existe un curso con el c�digo que se desea asignar, no se cambiar la informaci�n del curso. <br>
     * <b>pre: </b> Existe un curso con el c�digo dado. <br>
     * <b>post: </b> El curso tiene el nuevo c�digo, nombre, cr�ditos y departamento dados por par�metro.
     * @param pCodigoActual C�digo actual del curso a cambiar. pCodigoActual != null && pCodigoActual != "".
     * @param pNuevoCodigo Nuevo c�digo del curso. pNuevoCodigo != null && pNuevoCodigo != "".
     * @param pNombre Nombre del curso. pNombre != null && pNombre != "".
     * @param pCreditos Cr�ditos del curso. pCreditos > 0.
     * @param pDepartamento Departamento del curso.
     * @return Retorna true si se cambi� el curso, false si no se cambi� porque ya exist�a un curso con el c�digo que se deseaba asignar.
     */
    public boolean cambiarCurso( String pCodigoActual, String pNuevoCodigo, String pNombre, int pCreditos, Departamento pDepartamento )
    {
        boolean asigno = false;
        if( buscarCurso( pNuevoCodigo ) == null )
        {
            if( curso1.darCodigo( ).equals( pCodigoActual ) )
            {
                curso1 = new Curso( pNuevoCodigo, pNombre, pCreditos, pDepartamento );
            }
            else if( curso2.darCodigo( ).equals( pCodigoActual ) )
            {
                curso2 = new Curso( pNuevoCodigo, pNombre, pCreditos, pDepartamento );
            }
            else if( curso3.darCodigo( ).equals( pCodigoActual ) )
            {
                curso3 = new Curso( pNuevoCodigo, pNombre, pCreditos, pDepartamento );
            }
            else if( curso4.darCodigo( ).equals( pCodigoActual ) )
            {
                curso4 = new Curso( pNuevoCodigo, pNombre, pCreditos, pDepartamento );
            }
            asigno = true;
        }
        return asigno;
    }
    
    
    /**
     * calcula el sueldo que tendr�a el estudiante si fuera monitor, en funci�n de su promedio y del semestre en el que va
     * @param pPromedio Promedio del estudiante.
     * @param pSemestre Semestre del estudiante.
 	* @return Sueldo calculado. Si alg�n valor es 0, retorna 0.0.
  	*/
     
     public double calcularSueldo(double pPromedio, int pSemestre) {
         if (pSemestre == 0) {
             return 0.0;
         }

         if (pSemestre >= 1 && pSemestre <= 3) {
             return pPromedio >= 4.0 ? 25000.00 : 15000.00;
         } else if (pSemestre >= 4 && pSemestre <= 7) {
             return pPromedio >= 4.5 ? 35000.00 : 25000.00;
         } else if (pSemestre >= 8) {
             return 50000.00;
         }

         return 0.0; // Por si acaso no entra en ning�n rango
     }

     
     public String darSueldoFormateado() {
         double promedio = calcularPromedioEstudiante();
         double sueldo = calcularSueldo(promedio, semestre);

         DecimalFormat formatter = new DecimalFormat("#,###.00");
         return formatter.format(sueldo);
     }
     
     public double darMejorNota() {
         double mejor = -1.0;

         if (curso1.estaCalificado()) {
             mejor = curso1.darNota();
         }
         if (curso2.estaCalificado() && curso2.darNota() > mejor) {
             mejor = curso2.darNota();
         }
         if (curso3.estaCalificado() && curso3.darNota() > mejor) {
             mejor = curso3.darNota();
         }
         if (curso4.estaCalificado() && curso4.darNota() > mejor) {
             mejor = curso4.darNota();
         }

         return mejor;
     }

    // -----------------------------------------------------------------
    // Puntos de Extensi�n
    // -----------------------------------------------------------------

    /**
     * M�todo para la extensi�n 1.
     * @return Respuesta 1.
     */
    public String metodo1( )
    {
    	return "El sueldo del estudiante si fuera monitor: $" + darSueldoFormateado();
    }

    /**
     * M�todo para la extensi�n 2.
     * @return Respuesta 2.
     */
    public String metodo2( )
    {
        return "La mejor nota del estudiante es: " + darMejorNota();
    }
}