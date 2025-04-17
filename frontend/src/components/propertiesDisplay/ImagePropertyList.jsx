import React, {useState, useEffect, use} from 'react';
import axios from 'axios';
import { Navigation, Scrollbar, A11y } from 'swiper/modules';
import { Swiper, SwiperSlide } from 'swiper/react';
import 'swiper/css';
import 'swiper/css/navigation';
import 'swiper/css/pagination';
import 'swiper/css/scrollbar';
import "./propertiesDisplay.css"

function ImagePropertyList(props) {


    const [tabImages, setImages] = useState([]);

    const loadAllImagesByPropertyId = async () => {
        try {
            const result = await axios.get(`http://localhost:9696/ImageProperty${props.typeProprety}/getAllImagesByPropertyId?propertyIdProperty=${props.idPropriete}`);
            setImages(result.data);

        }catch (error){
            console.error(error)
        }

    };


    useEffect(() => {
        loadAllImagesByPropertyId();
    }, []);


    return (  // data.split(",")[1] get juste les liens dans la liste de String du repo


        <Swiper className={"swiperImage"}   //swiperjs
            modules={[Navigation, Scrollbar, A11y]}

            navigation
            pagination={{ clickable: true }}
            scrollbar={{ draggable: true }}
        >
            {tabImages.map((data, i) => (
                <SwiperSlide className={"swiperSlideImage"}  key={i}>
                    <img src={data.split(",")[1]}/>
                </SwiperSlide>
            ))}
        </Swiper>

    )


}

export default ImagePropertyList;