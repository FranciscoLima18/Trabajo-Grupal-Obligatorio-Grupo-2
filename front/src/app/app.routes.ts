import { Routes } from '@angular/router';
import { Login } from './components/login/login';
import { HomeCiudadano } from './components/home-ciudadano/home-ciudadano';
import { Votar } from './components/votar/votar';
import { ResultadosEleccion } from './components/resultados-eleccion/resultados-eleccion';
import { ResultadosCircuitos } from './components/miembros_mesa/resultados-circuitos/resultados-circuitos';

export const routes: Routes = [
    {
        path: '',
        component: Login
    },
    {
        path: 'home-ciudadano',
        component: HomeCiudadano
    },
    {
        path: 'votar',
        component: Votar
    },
    {
        path: 'Resultados-Elecciones',
        component: ResultadosEleccion
    },
    {
        path: 'Resultados-Circuitos',
        component: ResultadosCircuitos
    }
];
