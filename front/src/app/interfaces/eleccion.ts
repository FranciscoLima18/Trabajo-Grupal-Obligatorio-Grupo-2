export interface Eleccion {
  eleccionId: number;
  fecha: string;
  tipo: 'presidencial' | 'municipal' | 'plebiscito' | 'referendum' | 'ballotage';
}