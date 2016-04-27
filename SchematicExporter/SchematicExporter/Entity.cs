using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SchematicExporter
{
    class Entity
    {
        String jClass;

        public Entity(String jClass)
        {
            this.jClass = jClass;
        }

        public String getName()
        {
            return this.jClass;
        }
    }
}
