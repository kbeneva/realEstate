import {Route, BrowserRouter, Routes} from 'react-router-dom'
import React from 'react';
import './App.css'
import NotFound from './pages/NotFound.jsx'
import PropertiesListCard from "./components/PropertiesListCard.jsx";
import ImagePropertyList from "./components/ImagePropertyList.jsx";


function App() {
    return (
        <BrowserRouter>

            <div>
                <Routes>

                    < Route path='/' element={<PropertiesListCard/>}/>

                    < Route path='*' element={<NotFound/>}/>
                </Routes>

            </div>

        </BrowserRouter>

    );
}

export default App;