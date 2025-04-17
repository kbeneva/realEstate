import React, {useEffect, useState} from 'react';
import axios from "axios";
import {useParams} from "react-router-dom";
import ImagePropertyList from "./ImagePropertyList.jsx";
import Navbar from "../navbar/Navbar.jsx";
import "./propertyView.css"
import {FaBath, FaBed} from "react-icons/fa";
import {FaLocationDot} from "react-icons/fa6";
import {LuCircleParking} from "react-icons/lu";
import {BiSolidCarGarage} from "react-icons/bi";


function PropertyView() {


    // const {id} = useParams()
    const [property, setProperty] = useState({});


    const loadProperty = async () => {
        try {
            const result = await axios.get(`http://localhost:9696/propertySale/9981310`);
            setProperty(result.data);


        } catch (error) {
            console.error("property not found")
        }

    }

    useEffect(() => {
        loadProperty();
    }, []);


    if (!property.price) {  /// méthode toLocaleString est appelé avant les données
        return <div>loading property</div>
    }

    const priceType = property?.typeProperty === "rent" ? "/month" : "";

    return (
        <div>

            <Navbar/>


            <div className={"containerProperty"}>
                <div className={"containerType"}>

                    <h1 style={{color: "#2831e5"}}>{property.categorie} to {property.typeProperty}</h1>
                    <div className={"priceAddress"}>
                        <div className={"containerAddress"}>
                            <h1><FaLocationDot/> {property.address},</h1>
                            <h1>{property.city}</h1></div>

                        <div className={"containerPrice"}>
                            <h1>{property.price.toLocaleString("fr-ca", {
                                style: "currency",
                                currency: "CAD"
                            })}</h1>
                            <h1 className={"price"} style={{fontSize: "30px"}}>{priceType}</h1>
                        </div>
                    </div>


                </div>
                <div className={"carouselProperty"}>
                    <ImagePropertyList idPropriete={"9981310"} typeProprety={"Sale"}/>
                </div>

                <h3 style={{color: " #2831e5", fontSize: "20px"}}>Features </h3>
                <div className={"containerDetails"}>

                    <p><FaBed/>{property.nbRooms} room(s)</p>
                    <p><FaBath/>{property.nbBathrooms} bathroom(s)</p>
                    <p><LuCircleParking/>{property.nbParkingSpace} parking space(s)</p>
                    <p><BiSolidCarGarage/>{property.nbGarages} garage(s)</p>
                    <div >
                        <p className={"area"}>area</p>
                        <p>{property.area} pc</p>
                    </div>
                    <div >
                        <p className={"year"}>Construction year</p>
                        <p >{property.constructionYear}</p>
                    </div>


                </div>

                <div className={"descAgent"}>
                    <div className={"description"}>
                        <h3 style={{color: " #2831e5", fontSize: "20px"}}>Description</h3>
                        <p>{property.description}</p>
                    </div>


                    <div className={"agentContainer"}>
                        <div className={"pfp"}>
                            <img src={"pfp.jpg"}/>
                        </div>
                        <div className={"agentDetails"}>
                            <div className={"nameAgent"}><p> {property.agent.fname}</p>
                                <p>{property.agent.lname}</p></div>

                            <p> {property.agent.email}</p>
                            <p> {property.agent.phone}</p>
                            <button style={{background: "#2831e5"}}>contact</button>
                        </div>

                    </div>

                </div>
            </div>


        </div>
    );
}

export default PropertyView;