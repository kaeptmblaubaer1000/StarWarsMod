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
        String package;

        public Entity(String jClass, String package)
        {
            this.jClass = jClass;
            this.package = package;
        }

        public String getName()
        {
            return this.jClass;
        }

        public String getPackage()
        {
            return this.package;
        }

        public String getQualifiedName()
        {
            return this.package + "." + this.jClass;
        }
    }
}
