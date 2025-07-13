export interface Papeleta {
  papeletaId: number;
  color: string;
  tipo: string;
  eleccion?: {
    eleccionId: number;
    tipo: string;
    fecha: string;
  };
}
