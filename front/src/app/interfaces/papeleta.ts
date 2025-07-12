export interface Papeleta {
  papeletaId: number;
  eleccionId: number;
  tipo: 'lista' | 'plebiscito' | 'referendum' | 'ballotage';
  color: string;
}