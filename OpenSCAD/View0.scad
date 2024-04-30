difference()
{
    linear_extrude(height = 20.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
    {
        scale([110.0, 110.0])
        {
            M8();
        }
    }
    translate([-30.0, 30.0, 0.0])
    {
        linear_extrude(height = 17.0, twist = 0.0, scale = 1.0, slices = 1, center = false)
        {
            scale([30.0, 30.0])
            {
                M8();
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
