import React, {useState, useEffect, use} from 'react';
import axios from 'axios';
import {data, Link} from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.css';
import Carousel from 'react-bootstrap/Carousel';
import Card from "react-bootstrap/Card";


function ImagePropertyList(props) {


    const [tabImages, setImages] = useState([]);

    const loadAllImagesByPropertyId = async () => {
        const result = await axios.get(`http://localhost:9696/ImagePropertyRent/getAllImagesByPropertyId?propertyRentIdProperty=${props.idPropriete}`);
        setImages(result.data);

    };


    useEffect(() => {
        loadAllImagesByPropertyId();
    }, []);


    return(  // data.split(",")[1] get les liens dans la liste de String du repo
    <div>
        <Carousel >
        {tabImages.map((data, i) => (
            <Carousel.Item key={i} >
                <img src={data.split(",")[1]} />
            </Carousel.Item>
        ))}
        </Carousel>

    </div>

    )


}

export default ImagePropertyList;