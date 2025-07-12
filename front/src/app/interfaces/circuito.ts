export interface Circuito {
  circuitoId: number;
  departamento: string;
  localidad: string;
  barrio?: string;
  esAccesible: boolean;
}