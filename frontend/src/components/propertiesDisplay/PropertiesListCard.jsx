import { useState, useEffect } from 'react';
import axios from 'axios';
import { Link, useNavigate } from "react-router-dom";
import Card from 'react-bootstrap/Card';
import ImagePropertyList from "./ImagePropertyList.jsx";
<<<<<<< HEAD
import {FaLocationDot} from "react-icons/fa6";
import {FaBed} from "react-icons/fa";
import {FaBath} from "react-icons/fa";




function PropertiesListCard(propsFilters) { // par défaut, les filtres seront null, (sauf le prix et la categorie)

    const  {minPrice = '0',maxPrice = '3000000', nbRooms = '', nbBathrooms = '', nbParking = '', nbGarages = '', minArea = '', maxArea = '', minYear = '', maxYear = '', categorie = '', city = '', priceType = '', typePropriete = 'Rent'} = propsFilters;
    const [tabProperty, setProperty] = useState([]);
=======
import { FaLocationDot } from "react-icons/fa6";
import { FaBed, FaBath } from "react-icons/fa";
import './PropertiesListCard.css';

function PropertiesListCard(propsFilters) {
    const {
        minPrice = '0',
        maxPrice = '3000000',
        nbRooms = '',
        nbBathrooms = '',
        nbParking = '',
        nbGarages = '',
        minArea = '',
        maxArea = '',
        minYear = '',
        maxYear = '',
        categorie = '',
        city = '',
        priceType = '',
        propertyType = 'Rent'
    } = propsFilters;
>>>>>>> 47a1617 (Frontend + backend des soumissions et favorites)

    const [tabProperty, setProperty] = useState([]);
    const [heartStates, setHeartStates] = useState({});
    const [favoritesMap, setFavoritesMap] = useState({});
    const [showLoginPopup, setShowLoginPopup] = useState(false);
    const [showErrorPopup, setShowErrorPopup] = useState(false);
    const navigate = useNavigate();
    const user = JSON.parse(localStorage.getItem("user"));

    const loadAllProperty = async () => {
<<<<<<< HEAD
        const result = await axios.get(`http://localhost:9696/property${typePropriete}/filtre?minPrice=${minPrice}&maxPrice=${maxPrice}&nbRooms=${nbRooms}&nbBathrooms=${nbBathrooms}&nbParking=${nbParking}&nbGarages=${nbGarages}&minArea=${minArea}&maxArea=${maxArea}&minYear=${minYear}&maxYear=${maxYear}&categorie=${categorie}&city=${city}`);
        setProperty(result.data);

=======
        try {
            const result = await axios.get(`http://localhost:9696/property${propertyType}/filtre?minPrice=${minPrice}&maxPrice=${maxPrice}&nbRooms=${nbRooms}&nbBathrooms=${nbBathrooms}&nbParking=${nbParking}&nbGarages=${nbGarages}&minArea=${minArea}&maxArea=${maxArea}&minYear=${minYear}&maxYear=${maxYear}&categorie=${categorie}&city=${city}`);
            setProperty(result.data);
        } catch (error) {
            console.error("Error fetching properties:", error);
        }
>>>>>>> 47a1617 (Frontend + backend des soumissions et favorites)
    };

    const loadFavorites = async () => {
        if (!user) return;
        try {
            const res = await axios.get(`http://localhost:9696/api/favorites/${user.idUser}`);
            const map = {};
            res.data.forEach(fav => {
                const property = fav.propertySale || fav.propertyRent;
                if (property) {
                    map[property.idProperty] = fav.idFavorite;
                }
            });
            setFavoritesMap(map);
            const initialHearts = {};
            Object.keys(map).forEach(propertyId => {
                initialHearts[propertyId] = true;
            });
            setHeartStates(initialHearts);
        } catch (error) {
            console.error("Error fetching favorites:", error);
        }
    };

    useEffect(() => {
        loadAllProperty();
        loadFavorites();
    }, [propsFilters]);

    const toggleHeart = async (propertyId) => {
        if (!user) {
            setShowLoginPopup(true);
            return;
        }
        if (user.role !== "customer") {
            setShowErrorPopup(true);
            return;
        }

        if (heartStates[propertyId]) {
            try {
                const favId = favoritesMap[propertyId];
                if (favId) {
                    await axios.delete(`http://localhost:9696/api/favorites/${favId}`);
                    setHeartStates(prev => ({ ...prev, [propertyId]: false }));
                    const updatedMap = { ...favoritesMap };
                    delete updatedMap[propertyId];
                    setFavoritesMap(updatedMap);
                }
            } catch (error) {
                console.error("Error deleting favorite:", error);
            }
        } else {
            try {
                const res = await axios.post(`http://localhost:9696/api/favorites/add`, null, {
                    params: {
                        customerId: user.idUser,
                        propertyId: propertyId,
                        type: propertyType.toLowerCase()
                    }
                });
                setHeartStates(prev => ({ ...prev, [propertyId]: true }));
                setFavoritesMap(prev => ({ ...prev, [propertyId]: res.data.idFavorite }));
            } catch (error) {
                console.error("Error adding favorite:", error);
            }
        }
    };

    const CapitalizedText = (text) => {
        return text.charAt(0).toUpperCase() + text.slice(1);
    };

    const handleLoginRedirect = () => {
        navigate("/login");
    };

    const handleCancel = () => {
        navigate("/");
    };

    return (
<<<<<<< HEAD

        <div id={"cardProperties"}>

                {tabProperty.map((data) => (
                        <Card key={data.idProperty}>
                            <Link to={`/property/${CapitalizedText(data.typeProperty)}/${data.idProperty}`}>
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
                            </Link>

                        </Card>

                ))}
=======
        <div id="cardProperties">
            {tabProperty.map((data) => (
                <Card key={data.idProperty}>
                    <Link to={`/property/${CapitalizedText(data.typeProperty)}/${data.idProperty}`}>
                        <div className="carouselHolder">
                            <ImagePropertyList idPropriete={data.idProperty} typeProprety={propertyType} />
                        </div>
                        <Card.Body className="cardBody">
                            <div className="cardHeader">
                                <div className="cardPrice">
                                    <Card.Title className="priceText">
                                        {data.price.toLocaleString("fr-ca", { style: "currency", currency: "CAD" })}
                                    </Card.Title>
                                    <span className="priceUnit">
                                        {propertyType === "Rent" ? "/month" : ""}
                                    </span>
                                </div>
                                <img
                                    src={heartStates[data.idProperty] ? "fullHeart.png" : "emptyHeart.png"}
                                    alt="Heart Icon"
                                    className="heartIcon"
                                    onClick={(e) => {
                                        e.preventDefault();
                                        toggleHeart(data.idProperty);
                                    }}
                                />
                            </div>
                            <Card.Text as="div" className="cardLocation">
                                <div><FaLocationDot /> {data.address},</div>
                                <div>{data.city}</div>
                            </Card.Text>
                            <Card.Text as="div" className="cardFeatures">
                                <div><FaBed size={23} />{data.nbRooms}</div>
                                <div><FaBath size={22} />{data.nbBathrooms}</div>
                            </Card.Text>
                        </Card.Body>
                    </Link>
                </Card>
            ))}
>>>>>>> 47a1617 (Frontend + backend des soumissions et favorites)

            {showLoginPopup && (
                <div className="popup">
                    <div className="popupContent">
                        <p>You must be logged in to save a property.</p>
                        <button className="popupButton1" onClick={handleLoginRedirect}>Login</button>
                        <button className="popupButton2" onClick={handleCancel}>Cancel</button>
                    </div>
                </div>
            )}

            {showErrorPopup && (
                <div className="popup">
                    <div className="popupContent">
                        <p>Only customers can save properties.</p>
                        <button className="popupButton1" onClick={handleCancel}>Return to Home</button>
                    </div>
                </div>
            )}
        </div>
<<<<<<< HEAD

=======
>>>>>>> 47a1617 (Frontend + backend des soumissions et favorites)
    );
}

export default PropertiesListCard;
