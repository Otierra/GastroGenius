package Gestion.Controlador;

import Gestion.Modelo.ModeloReporte;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestionReporte {
    private static List<ModeloReporte> reportes = new ArrayList<>();

    public static List<ModeloReporte> obtenerReportes() {
        return new ArrayList<>(reportes);
    }

    public static void limpiarReportes() {
        reportes.clear();
    }

    public static void agregarReporte(ModeloReporte reporte) {
        reportes.add(reporte);
    }

    public static List<ModeloReporte> obtenerReportesPorRangoFechas(String fechaFrom, String fechaTo) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MMM/yyyy");
        List<ModeloReporte> reportesEnRango = new ArrayList<>();
        
        try {
            Date dateFrom = formatoFecha.parse(fechaFrom);
            Date dateTo = formatoFecha.parse(fechaTo);

            for (ModeloReporte reporte : reportes) {
                Date fechaReporte = formatoFecha.parse(reporte.getFecha());
                if (!fechaReporte.before(dateFrom) && !fechaReporte.after(dateTo)) {
                    reportesEnRango.add(reporte);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return reportesEnRango;
    }
}
