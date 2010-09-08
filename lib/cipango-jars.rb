module CipangoJars
  PATH = File.expand_path(File.dirname(__FILE__))

  class << self 
    def all_jar_names
      @all_jar_names ||= []
    end
    
    def all_jar_paths
      @all_jar_paths ||= []
    end
    
    {
      'cipango' => '1.0',
      'cipango-dar' => '1.0', 
      'sip-api' => '1.1', 
      'jetty' => '6.1.24', 
      'jetty-util' => '6.1.24', 
      'servlet-api' => '2.5-20081211',
      'cipango-main' => '1.0'
    }.each_pair do |name, version|
      uname = name.gsub(/-/, '_')
      jar_name = "#{name}-#{version}.jar"
      jar_path = "#{PATH}/#{jar_name}"
      define_method("#{uname}_jar_path") { jar_path }
      CipangoJars.all_jar_names << jar_name
      CipangoJars.all_jar_paths << jar_path
    end
  end
end
