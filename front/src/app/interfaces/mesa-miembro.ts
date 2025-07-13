import { Ciudadano } from './ciudadano';
import { Mesa } from './mesa';
export interface MesaMiembro {
  ciudadano: Ciudadano; 
  mesa: Mesa;             
  rol: string;
  organismo: string;
}
