export interface VotoCabecera {
  ciudadanoId: number;
  eleccionId: number;
  circuitoId: number;
  observado: boolean;
  fechaHora?: string;
  estadoVoto: 'valido' | 'anulado' | 'en_blanco';
  causalAnulacion?: string;
}