import { Routes } from '@angular/router';
import { Login } from './components/login/login';
import { HomeCiudadano } from './components/home-ciudadano/home-ciudadano';
import { ResultadosEleccion } from './components/resultados-eleccion/resultados-eleccion';
import { ResultadosCircuitos } from './components/resultados-circuitos/resultados-circuitos';
import { RegistroComponent } from './components/registro/registro';
import { Votar } from './components/votar/votar';
import { HomeMesa } from './components/home-mesa/home-mesa';
import { VerCircuitos } from './components/ver-circuitos/ver-circuitos';

export const routes: Routes = [
    {
        path: '',
        component: Login
    },
    {
        path: 'registro',
        component: RegistroComponent
    },
    {
        path: 'home-ciudadano/:id',
        component: HomeCiudadano
    },
    {
        path: 'home-mesa/:id',
        component: HomeMesa
    },
    {
        path: 'resultados-eleccion',
        component: ResultadosEleccion
    },
    {
        path: 'home-mesa/:id/resultados-circuitos',
        component: ResultadosCircuitos
    },
    {
        path: 'votar/:ciudadanoId/:eleccionId',
        component: Votar
    },
    {
        path: 'circuitos/:id',
        component: VerCircuitos
    }
];
