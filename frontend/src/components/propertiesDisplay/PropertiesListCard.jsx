import React, {useState, useEffect} from 'react';
import axios from 'axios';
import {data, Link} from "react-router-dom";
import Card from 'react-bootstrap/Card';
import ImagePropertyList from "./ImagePropertyList.jsx";
import {FaLocationDot} from "react-icons/fa6";
import {FaBed} from "react-icons/fa";
import {FaBath} from "react-icons/fa";




function PropertiesListCard(propsFilters) { // par défaut, les filtres seront null, (sauf le prix et la categorie)

    const  {minPrice = '0',maxPrice = '3000000', nbRooms = '', nbBathrooms = '', nbParking = '', nbGarages = '', minArea = '', maxArea = '', minYear = '', maxYear = '', categorie = '', city = '', priceType = '', typePropriete = 'Rent'} = propsFilters;
    const [tabProperty, setProperty] = useState([]);


    const loadAllProperty = async () => {
        const result = await axios.get(`http://localhost:9696/property${typePropriete}/filtre?minPrice=${minPrice}&maxPrice=${maxPrice}&nbRooms=${nbRooms}&nbBathrooms=${nbBathrooms}&nbParking=${nbParking}&nbGarages=${nbGarages}&minArea=${minArea}&maxArea=${maxArea}&minYear=${minYear}&maxYear=${maxYear}&categorie=${categorie}&city=${city}`);
        setProperty(result.data);

    };


    useEffect(() => {   ///load à chaque fois que les filtres changes
        loadAllProperty();
    }, [propsFilters]);


    return (

        <div id={"cardProperties"}>

            

                {tabProperty.map((data) => (
                        <Card key={data.idProperty}>
                            <div className={"carouselHolder"}>
                                <ImagePropertyList idPropriete={data.idProperty} typeProprety={typePropriete}/>
                            </div>

                            <Card.Body style={{paddingLeft: "10px"}}>
                                <div>
                                    <Card.Title style={{display: "inline-flex"}}>{data.price.toLocaleString("fr-ca", {
                                        style: "currency",
                                        currency: "CAD"
                                    })}
                                        <div style={{fontSize: "15px", alignContent: "end"}}>
                                            {priceType}
                                        </div>
                                    </Card.Title>
                                </div>
                                <Card.Text as={"div"} style={{paddingTop: "10px",}}>
                                    <div><FaLocationDot/> {data.address},</div>
                                    <div style={{paddingLeft: "3px"}}> {data.city}</div>
                                </Card.Text>
                                <div>
                                    <Card.Text as={"div"} style={{display: "inline-flex", paddingTop: "20px"}}>
                                        <div><FaBed size={23} style={{marginRight: "0.5rem"}}/>{data.nbRooms}</div>
                                        <div style={{paddingInlineStart: "1rem"}}><FaBath size={22} style={{marginRight: "0.5rem"}}/>{data.nbBathrooms}
                                        </div>
                                    </Card.Text>
                                </div>

                            </Card.Body>
                        </Card>

                ))}

        </div>

    );
}


export default PropertiesListCard;