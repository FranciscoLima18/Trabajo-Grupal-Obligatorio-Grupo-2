import { Circuito } from './circuito';
import { Ciudadano } from './ciudadano';
export interface AsignacionCircuito {
  ciudadanoId: number;
  circuitoId: number;
  ciudadano?: Ciudadano;
  circuito?: Circuito;    
}
