import {Route, BrowserRouter, Routes} from 'react-router-dom'
import React from 'react';
import './App.css'
import NotFound from './pages/NotFound.jsx'
import PropertiesListCard from "./components/PropertiesListCard.jsx";
import ImagePropertyList from "./components/ImagePropertyList.jsx";
import PropertiesSaleListCard from "./components/PropertiesSaleListCard.jsx";


function App() {
    return (
        <BrowserRouter>

            <div>
                <Routes>

                    < Route path='/' element={<PropertiesSaleListCard/>}/>

                    < Route path='*' element={<NotFound/>}/>
                </Routes>

            </div>

        </BrowserRouter>

    );
}

export default App;