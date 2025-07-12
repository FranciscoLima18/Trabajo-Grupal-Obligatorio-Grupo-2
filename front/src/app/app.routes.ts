import { Routes } from '@angular/router';
import { Login } from './components/login/login';
import { HomeCiudadano } from './components/home-ciudadano/home-ciudadano';
import { ResultadosEleccion } from './components/resultados-eleccion/resultados-eleccion';
import { ResultadosCircuitos } from './components/resultados-circuitos/resultados-circuitos';
import { Registro } from './components/registro/registro';
import { Votar } from './components/votar/votar';

export const routes: Routes = [
    {
        path: '',
        component: Login
    },
    {
        path: 'registro',
        component: Registro
    },
    {
        path: 'home-ciudadano',
        component: HomeCiudadano
    },
    {
        path: 'Resultados-Elecciones',
        component: ResultadosEleccion
    },
    {
        path: 'Resultados-Circuitos',
        component: ResultadosCircuitos
    },
    {
        path: 'votar',
        component: Votar
    }
];
