import {Route, BrowserRouter, Routes} from 'react-router-dom'
import React from 'react';
import './App.css'
import NotFound from './pages/NotFound.jsx'
import Accueil from './pages/Accueil.jsx'


function App() {
    return (
        <BrowserRouter>

            <div>
                <Routes>

                    < Route path='/' element={<Accueil/>}/>

                    < Route path='*' element={<NotFound/>}/>
                </Routes>

            </div>

        </BrowserRouter>

    );
}

export default App;