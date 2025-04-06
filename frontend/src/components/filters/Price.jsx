import React, { useState } from 'react';
import Box from '@mui/material/Box';
import Slider from '@mui/material/Slider';
import './Price.css';

function Price() {
    const [value, setValue] = useState([0, 3000000]);

    const handleChange = (event, newValue) => {
        setValue(newValue);
    };

    return (
        <Box className="priceSliderContainer">
            <Slider
                className="priceSlider"
                getAriaLabel={() => 'Price range'}
                value={value}
                onChange={handleChange}
                valueLabelDisplay="off"
                min={0}
                max={3000000}
            />
            <Box sx={{ display: 'flex', justifyContent: 'space-between', marginTop: 2 }}>
                <Box className="valueBox">{value[0]}</Box>
                <Box className="valueBox">{value[1]}</Box>
            </Box>
        </Box>
    );
}

export default Price;