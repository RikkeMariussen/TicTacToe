union()
{
    linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
    {
        scale([111.5, 111.5])
        {
            M8();
        }
    }
    union()
    {
        union()
        {
            union()
            {
                translate([0.0, 17.84, 0.0])
                {
                    linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                    {
                        scale([106.5, 2.5])
                        {
                            M8();
                        }
                    }
                }
                translate([17.84, 0.0, 0.0])
                {
                    linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                    {
                        scale([2.5, 106.5])
                        {
                            M8();
                        }
                    }
                }
            }
            union()
            {
                translate([0.0, -17.84, 0.0])
                {
                    linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                    {
                        scale([106.5, 2.5])
                        {
                            M8();
                        }
                    }
                }
                translate([-17.84, 0.0, 0.0])
                {
                    linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                    {
                        scale([2.5, 106.5])
                        {
                            M8();
                        }
                    }
                }
            }
        }
        union()
        {
            union()
            {
                translate([-52.9625, 0.0, 0.0])
                {
                    linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                    {
                        scale([2.5, 106.5])
                        {
                            M8();
                        }
                    }
                }
                translate([52.9625, 0.0, 0.0])
                {
                    linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                    {
                        scale([2.5, 106.5])
                        {
                            M8();
                        }
                    }
                }
            }
            union()
            {
                translate([0.0, 52.9625, 0.0])
                {
                    linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                    {
                        scale([106.5, 2.5])
                        {
                            M8();
                        }
                    }
                }
                translate([0.0, -52.9625, 0.0])
                {
                    linear_extrude(height = 10.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
                    {
                        scale([106.5, 2.5])
                        {
                            M8();
                        }
                    }
                }
            }
        }
    }
}

module M8()
{
    polygon
    (
        points =
        [
            [-0.5, -0.5], 
            [0.5, -0.5], 
            [0.5, 0.5], 
            [-0.5, 0.5]
        ],
        paths =
        [
            [0, 1, 2, 3]
        ]
    );
}
