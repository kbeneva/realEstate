import {Route, BrowserRouter, Routes} from 'react-router-dom'
import React from 'react';
import './App.css'
import NotFound from './pages/NotFound.jsx'
import PropertiesRentList from "./components/PropertiesRentList.jsx";


function App() {
    return (
        <BrowserRouter>

            <div>
                <Routes>

                    < Route path='/' element={<PropertiesRentList/>}/>

                    < Route path='*' element={<NotFound/>}/>
                </Routes>

            </div>

        </BrowserRouter>

    );
}

export default App;