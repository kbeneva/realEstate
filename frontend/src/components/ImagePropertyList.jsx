import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {Link} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css';
import Card from "react-bootstrap/Card";


function ImagePropertyList(idProprete) {


    const [tabImages, setImages] = useState([]);

    const loadAllImagesByPropertyId = async () => {
        const result = await axios.get(`http://localhost:9696/ImagePropertyRent/getAllImagesByPropertyId?propertyRentIdProperty=9640892`);
        setImages(result.data);
    };


    useEffect(() => {
        loadAllImagesByPropertyId();
    }, []);



    return (
       <div>
           {tabImages.map((data) => (
               <tr key={data.}>
                   <td> </td>
               </tr>

           ))}
       </div>
    );
}

export default ImagePropertyList;